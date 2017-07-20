var appModule = angular.module('myApp', []);

appModule.controller('MainCtrl', ['mainService','$scope','$http',
        function(mainService, $scope, $http) {
            $scope.greeting = 'Welcome to the JSON Web Token / AngularJR / Spring example!';
            $scope.token = null;
            $scope.error = null;
            $scope.roleUser = false;
            $scope.roleAdmin = false;
            $scope.roleFoo = false;

            $scope.login = function() {
                console.log('controller-- login')
                $scope.error = null;
                mainService.login($scope.userName).then(function(token) {
                    $scope.token = token;
                    $http.defaults.headers.common.Authorization = 'Bearer ' + token;
                    $scope.checkRoles();
                },
                function(error){
                    $scope.error = error
                    $scope.userName = '';
                });
            }

            $scope.checkRoles = function() {
                console.log('controller-- checkRoles')
                mainService.hasRole('user').then(function(user) {$scope.roleUser = user});
                mainService.hasRole('admin').then(function(admin) {$scope.roleAdmin = admin});
                mainService.hasRole('foo').then(function(foo) {$scope.roleFoo = foo});
            }

            $scope.logout = function() {
                console.log('controller-- logout')
                $scope.userName = '';
                $scope.token = null;
                $http.defaults.headers.common.Authorization = '';
            }

            $scope.loggedIn = function() {
                console.log('controller-- loggedIn')
                return $scope.token !== null;
            }
        } ]);



appModule.service('mainService', function($http) {
    return {
        login : function(username) {
            console.log('service-- login')
            return $http.post('/user/login', {name: username}).then(function(response) {
                return response.data.token;
            });
        },

        hasRole : function(role) {
            console.log('service-- hasRole')
            return $http.get('/api/role/' + role).then(function(response){
                console.log(response);
                return response.data;
            });
        }
    };
});

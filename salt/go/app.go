package main

import (
  _ "github.com/go-sql-driver/mysql"
  "database/sql"
  "encoding/json"
  "fmt"
  "log"
  "net/http"
)

var db *sql.DB

type Row struct {
  Id string
  Account string
  Name string
}

type Data struct {
  Length int
  Content []Row
}

type Description struct {
  Classification string
  Language string
  Platform string
  Frontend string
  OS string
}

type User struct {
  User []Row
}

type Result struct {
  Classification string
  Language string
  Platform string
  FrontEnd string
  OS string
  Data Data
}

func init() {
  db, _ = sql.Open("mysql", "root:@/zhongruan?charset=utf8")
  db.SetMaxOpenConns(100)
  db.SetMaxIdleConns(1)
  db.Ping()
}

func description(w http.ResponseWriter, r *http.Request) {
  var desc Description
  desc.Classification = "Platform"
  desc.Language = "Go"
  desc.Platform = "None"
  desc.Frontend = "None"
  desc.OS = "Windows"
  res, err := json.Marshal(desc)
  if (err != nil) {
    log.Fatal(err)
  }
  fmt.Fprintf(w, string(res))
}

func user(w http.ResponseWriter, r *http.Request) {
  rows, err := db.Query("select id, account, name from user")
  if (err != nil) {
    log.Fatal(err)
  }
  var user []Row
  for rows.Next() {
    var r Row
    err = rows.Scan(&r.Id, &r.Account, &r.Name)
    if (err != nil) {
      log.Fatal(err)
    }
    user = append(user, r)
  }
 
  res, _ := json.Marshal(user)
  fmt.Fprintf(w, string(res))
}

func test(w http.ResponseWriter, r *http.Request) {
  var d Result
  d.Classification = "Platform"
  d.Language = "Go"
  d.Platform = "None"
  d.FrontEnd = "None"
  d.OS = "Windows"

  rows, err := db.Query("select id, account, name from user")
  checkErr(err)

  var data Data
  for rows.Next() {
    var r Row
    err = rows.Scan(&r.Id, &r.Account, &r.Name)
    checkErr(err)
    data.Content = append(data.Content, r)
  }
  data.Length = len(data.Content)
  // fmt.Println(data)
  d.Data = data
  
  res, err := json.Marshal(d)
  if err != nil {
    log.Fatal(err)
  }

  // fmt.Println(string(res))
  fmt.Fprintf(w, string(res))
}

func main() {
  http.HandleFunc("/api/test", test)
  http.HandleFunc("/api/description", description)
  http.HandleFunc("/api/user", user)
  err := http.ListenAndServe(":9090", nil)
  if err != nil {
    log.Fatal("[error] ListenAndServe: ", err)
  }
}

func checkErr(err error) {
  if err != nil {
    panic(err)
  }
}

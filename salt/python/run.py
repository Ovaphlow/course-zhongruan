# -*- coding=UTF-8 -*-

import json

import tornado.httpserver
import tornado.ioloop
import tornado.web

from sqlalchemy import create_engine
from sqlalchemy import text


DATABASE = {
    'USER': 'root',
    'PASSWORD': '',
    'HOST': '127.0.0.1',
    'NAME': 'zhongruan'
}

engine = create_engine('mysql+pymysql://%s:%s@%s/%s?charset=utf8' % (
        DATABASE['USER'],
        DATABASE['PASSWORD'],
        DATABASE['HOST'],
        DATABASE['NAME']),
    pool_recycle=900,
    pool_size=10)


class Description(tornado.web.RequestHandler):
    def get(self):
        result = {
            'Classification': 'Platform',
            'Language': 'Python',
            'Platform': 'None',
            'Frontend': 'Tornado',
            'OS': 'Linux'
        }
        self.write(result)


class User(tornado.web.RequestHandler):
    def get(self):
        connection = engine.connect()
        res = connection.execute(
            'select id, account, name from user'
        ).fetchall()
        connection.close()
        data = []
        for row in res:
            data.append({
                'id': row[0],
                'account': row[1],
                'name': row[2]
            })
        self.finish(json.dumps(data))


class MainHandler(tornado.web.RequestHandler):
    def get(self):
        connection = engine.connect()
        res = connection.execute(
            'select id, account, name from user'
        ).fetchall()
        connection.close()
        data = []
        for row in res:
            data.append({
                'id': row[0],
                'account': row[1],
                'name': row[2]
            })
        result = {
            'Classification': 'Platform',
            'Language': 'Python',
            'Platform': 'None',
            'Frontend': 'Tornado',
            'OS': 'Linux',
            'Data': {
                'Length': len(data),
                'Content': data
            }
        }
        self.write(result)


def make_app():
    return tornado.web.Application([
        (r"/api/test", MainHandler),
        (r"/api/description", Description),
        (r"/api/user", User)
    ])


def run():
    app = make_app()
    server = tornado.httpserver.HTTPServer(app)
    server.bind(9000)
    server.start(0)
    tornado.ioloop.IOLoop.current().start()


if __name__ == '__main__':
    run()

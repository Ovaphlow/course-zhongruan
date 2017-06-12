# -*- coding=UTF-8 -*-

from __future__ import division

import random


if __name__ == '__main__':
    death_a = death_b = 0
    for i in range(1, 10000 + 1):
        if 30 > random.randint(0, 100):
            death_b += 1
        else:
            if 50 > random.randint(0, 100):
                death_a += 1
        result_a = 1 - death_a / i
        result_b = 1 - death_b / i
        print('[info] (%s) A: %s, B: %s' % (i, death_a, death_b))
        print('--- A: %s, B: %s' % (result_a, result_b))

#!/usr/bin/python3
import os
import sys
from time import perf_counter as time


def write_test(file, block_size, blocks_count):
    f = os.open(file, os.O_CREAT | os.O_WRONLY, 0o777)  # low-level I/O

    start = time()
    for i in range(blocks_count):
        buff = bytearray(block_size)
        buff[0] = i & 0xFF
        os.write(f, buff)
        os.fsync(f)  # force write to disk

    os.close(f)
    return time() - start


def read_test(file, block_size, blocks_count):
    f = os.open(file, os.O_RDONLY)  # low-level I/O

    start = time()
    for i in range(blocks_count):
        buff = os.read(f, block_size)
        if buff[0] != i & 0xFF:
            raise RuntimeError(
                f"verify error at block {i}, data read: {buff[0]}")

    os.close(f)
    return time() - start


def main(file, block_size, blocks_count):
    print(f"write: {write_test(file, block_size, blocks_count)}")
    print(f"read: {read_test(file, block_size, blocks_count)}")


if __name__ == "__main__":
    main(sys.argv[1], int(sys.argv[2]), int(sys.argv[3]))

import sys
import socket

class SocketReader:

    def __init__(self, sock, mode='rb', bufsize=100):
        self._sock = sock
        self.bufsize = bufsize

    def read(self, size=-1):
        if size <= 0:
            size = sys.maxsize
        blocks = []
        while size > 0:
            b = self._sock.recv(min(size, self.bufsize))
            size -= len(b)
            if not b:
                break
            blocks.append(b)
        return "".join(blocks)

    def readline(self, size=-1):
        if size < 0:
            size = sys.maxsize
        blocks = []
        read_size = min(20, size)
        found = 0
        while size and not found:
            b = self._sock.recv(read_size, socket.MSG_PEEK)
            if not b:
                break
            found = b.find(b'\n') + 1
            length = found or len(b)
            size -= length
            blocks.append(self._sock.recv(length).decode())
            read_size = min(read_size * 2, size, self.bufsize)
        return "".join(blocks)


import socket
import socket
host='192.168.5.3'
port=5000
s=socket.socket()
s.connect((host,port))
message=raw_input("enter -->")
while True:
    s.send(message)
    if message=='quit':
        break

    data=s.recv(1024)
#    print str(data)
     
    message=raw_input()
s.close() 
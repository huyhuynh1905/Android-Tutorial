var express = require("express");
var app = express();
var server = require("http").createServer(app);
var io = require("socket.io").listen(server);
var fs = require("fs");
server.listen(process.env.PORT || 3000);
app.get("/", function (req,res) {
   res.sendFile(__dirname + "/index.html");
});

console.log("Server running!")

io.sockets.on('connection',function (socket) {
   console.log("Client connected!");
    socket.on('letter-from-client',function (data) {
        console.log("Client: "+data);
        io.sockets.emit('server-send-data',
            {noidung:data}
            );
    })
});
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
var arrUser = ["Admin"];
var kiemtra = false;


io.sockets.on('connection',function (socket) {
    //nhánh này dùng để đăng kí user
   console.log("Client connected!");
   //gửi danh sách nếu client mới mở
    if (arrUser!=null){
        //gửi danh sách user về các máy
        io.sockets.emit('server-send-user',{users:arrUser})
    }
    socket.on('client-register',function (data) {
        //Kiểm tra user tồn tại hay ko
        if (arrUser.indexOf(data) == -1){
            //không tồn tại user thì được phép đăng kí
            arrUser.push(data);
            kiemtra = true;
            console.log("Register "+data+": OK!");
            //gán tên user cho socket này
            socket.un = data;
            //gửi danh sách user về các máy
            io.sockets.emit('server-send-user',{users:arrUser})
        }  else {
            kiemtra = false;
            console.log("Register Error");
        }
        //Gửi kết quả đăng kí về client(Chỉ client nào gửi)
        socket.emit('server-register',{ketqua:kiemtra});
    });
    //nhánh này để nhận và gửi nội dung chat
    socket.on('client-chat',function (message) {
        console.log(socket.un+": "+message);
        io.sockets.emit('server-send-message',{content:socket.un+": "+message});
    });
});



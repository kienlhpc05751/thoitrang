/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.dao;


import com.raven.db.DBHelper;
import com.raven.utils.XDialogHelper;
import java.net.Authenticator;
//import javax.mail.Authenticator;
import java.util.Properties;
import java.util.Random;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
//import javax.mail.Message;
//import javax.mail.MessagingException;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeMessage;


/**
 *
 * @author Admin
 */
public class FogotPasswordDAO {
    public static ResultSet rs = null; // Trả về kết quả truy vấn
    public static String SELECT_EMAIL_SQL = "SELECT * FROM nhanvien WHERE Email=?";
    public static String UPDATE_PASSWORD_SQL = "UPDATE NhanVien SET Matkhau=? WHERE Email=?";
    public String newPass = getRandomString(6);

    private String getRandomString(int n) {
        String txt = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJLMNOPQRSTUVWXYZ1234567890!@#$%^&*()_+";
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            Random rd = new Random();
            sb.append(txt.charAt(rd.nextInt(txt.length())));
            n--;
        }
        return sb.toString();
    }
    private String message(String msg, String hoTen, String taiKhoan) {
        msg = "<div style='background-color:cyan;padding:15px;border-radius:10px;margin:0 auto;width:70%;line-height:25px;'>"
                + "Xin chào <b>" + hoTen + "</b>,<br/>"
                + "Chúng tôi muốn cho bạn biết rằng mật khẩu trên ứng dụng <b>Cửa Hàng Thời Trang Lightning Strike</b> của bạn đã được đặt lại."
                + "<br/><br/>"
                + "Tên tài khoản: " + taiKhoan + "<br/>"
                + "Mật khẩu mới của bạn là: <b>" + newPass + "</b><br/>"
                + "Vui lòng truy cập vào tài khoản và tiến hành thay đổi mật khẩu ngay!"
                + "<br/><br/>"
                + "Nếu bạn gặp sự cố, vui lòng liên hệ với bộ phận hỗ trợ thông qua email: "
                + "<a href='mailto:lamkimuyen2015@gmail.com'>lamkimuyen2015@gmail.com</a><br/>"
                + "Vui lòng không trả lời email này bằng mật khẩu của bạn. "
                + "Chúng tôi sẽ không bao giờ hỏi mật khẩu của bạn và "
                + "chúng tôi đặc biệt không khuyến khích bạn chia sẻ mật khẩu đó với bất kỳ ai.</div>";
        return msg;
    }

    public void update(String key) {
        DBHelper.update(UPDATE_PASSWORD_SQL, newPass, key);
    }
    public void sendMail(String email) throws MessagingException, SQLException {
    try {
        // Set default email account
        String senderEmail = "lamkimuyen2015@gmail.com";
        String senderPassword = "swzbpdhfcijzxipy";
        
        // ... Database query to get email details
        String recipientEmail = rs.getString("Email");
        String employeeId = rs.getString("MaNV");
        String employeeName = rs.getString("HoTen");

        // ... Configure the SMTP Server properties
        Properties props = new Properties();
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.port", "587");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");

        // ... Create a new session with an authenticator
        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(senderEmail, senderPassword);
            }
        });

        // ... Create and send the email
        MimeMessage message = new MimeMessage(session);
        message.setFrom(new InternetAddress(senderEmail));
        message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(recipientEmail));
        String subject = "Password has been reset - Cửa Hàng Thời Trang Lightning Strike";
        String body = createEmailBody(email, employeeId, employeeName, subject);
        message.setSubject(subject, "utf-8");
        message.setContent(body, "text/html;charset=utf-8");
        Transport.send(message);

    } catch (SQLException | MessagingException ex) {
        ex.printStackTrace();
        throw new RuntimeException(ex);

    } finally {
        closeResources();
    }
}

private String createEmailBody(String email, String employeeId, String employeeName, String subject) {
    // Create and return the email body
        return null;
    // Create and return the email body
}

private void closeResources() {
    try {
        if (rs != null) {
            rs.close();
        }
        // Close other resources (Statement, Connection) if needed
    } catch (SQLException e) {
        e.printStackTrace();
    }
}

}
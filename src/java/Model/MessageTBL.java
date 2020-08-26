/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

/**
 *
 * @author PhongFPT
 */
public class MessageTBL {
    int id;
    String messageTitle;
    String messageTime;
    String from,to;
    String messageContent;
    boolean isRead;

    public MessageTBL(String messageTitle, String from,String messageTime,  boolean isRead, int id) {
        this.messageTitle = messageTitle;
        this.messageTime = messageTime;
        this.from = from;
        this.isRead = isRead;
        this.id=id;
    }

    public MessageTBL(String from, String messageTitle, String messageTime,  String messageContent) {
        this.messageTitle = messageTitle;
        this.messageTime = messageTime;
        this.from = from;
        this.messageContent = messageContent;
    }

    public MessageTBL(int id, String messageTitle, String messageTime, String from, String to, String messageContent, boolean isRead) {
        this.id = id;
        this.messageTitle = messageTitle;
        this.messageTime = messageTime;
        this.from = from;
        this.to = to;
        this.messageContent = messageContent;
        this.isRead = isRead;
    }

    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMessageTitle() {
        return messageTitle;
    }

    public void setMessageTitle(String messageTitle) {
        this.messageTitle = messageTitle;
    }

    public String getMessageTime() {
        return messageTime;
    }

    public void setMessageTime(String messageTime) {
        this.messageTime = messageTime;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public void setMessageContent(String messageContent) {
        this.messageContent = messageContent;
    }

    public boolean isIsRead() {
        return isRead;
    }

    public void setIsRead(boolean isRead) {
        this.isRead = isRead;
    }

    @Override
    public String toString() {
        return "MessageTBL{" + "id=" + id + ", messageTitle=" + messageTitle + ", messageTime=" + messageTime + ", from=" + from + ", to=" + to + ", messageContent=" + messageContent + ", isRead=" + isRead + '}';
    }
    
}

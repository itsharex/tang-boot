package com.tang.app.entity;

import com.tang.commons.base.entity.BaseEntity;

/**
 * 聊天消息实体类 app_chat_message
 *
 * @author Tang
 */
public class AppChatMessage extends BaseEntity {

    @java.io.Serial
    private static final long serialVersionUID = -2343372416531013427L;

    /**
     * 消息ID
     */
    private Long messageId;

    /**
     * 聊天列表ID
     */
    private Long chatListId;

    /**
     * 发送者ID
     */
    private Long senderId;

    /**
     * 回复消息ID
     */
    private Long replyMessageId;

    /**
     * 回复消息
     */
    private AppChatMessage replyMessage;

    /**
     * 发送者用户名
     */
    private String username;

    /**
     * 发送者昵称
     */
    private String nickname;

    /**
     * 发送者头像
     */
    private String avatar;

    /**
     * 聊天内容
     */
    private String content;


    public Long getMessageId() {
        return messageId;
    }

    public void setMessageId(Long messageId) {
        this.messageId = messageId;
    }

    public Long getChatListId() {
        return chatListId;
    }

    public void setChatListId(Long chatListId) {
        this.chatListId = chatListId;
    }

    public Long getSenderId() {
        return senderId;
    }

    public void setSenderId(Long senderId) {
        this.senderId = senderId;
    }

    public Long getReplyMessageId() {
        return replyMessageId;
    }

    public void setReplyMessageId(Long replyMessageId) {
        this.replyMessageId = replyMessageId;
    }

    public AppChatMessage getReplyMessage() {
        return replyMessage;
    }

    public void setReplyMessage(AppChatMessage replyMessage) {
        this.replyMessage = replyMessage;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

}
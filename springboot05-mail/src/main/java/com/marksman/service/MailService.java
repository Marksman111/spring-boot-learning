package com.marksman.service;

/**
 * @author weilb
 * @date 2018/8/26
 * @description
 */
public interface MailService {

    void sendSimpleMail(String to,String subject,String context);

    void sendHtmlMail(String to,String subject,String content);

    void sendAttachmentsMail(String to,String subject,String content,String filePath);

    void sendInlineResourceMail(String to,String subject,String content,String rscPath,String rscId);
}
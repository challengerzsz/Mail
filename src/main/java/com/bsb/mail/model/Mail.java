package com.bsb.mail.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@Table(name = "mail_table")
@AllArgsConstructor
@NoArgsConstructor
public class Mail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "sender")
    private String sender;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "text")
    private String text;

    @Column(name = "isAttach")
    private Long isAttach;

    @Column(name = "attachment")
    private String attachment;

    @Column(name = "update_time")
    private Date updateTime;

    @Column(name = "create_time")
    private Date createTime;

    public Mail(String sender, String receiver, String text, Long isAttach, String attachment) {
        this.sender = sender;
        this.receiver = receiver;
        this.text = text;
        this.isAttach = isAttach;
        this.attachment = attachment;
    }
}
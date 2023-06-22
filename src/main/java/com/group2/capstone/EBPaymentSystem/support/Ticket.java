package com.group2.capstone.EBPaymentSystem.support;

import com.group2.capstone.EBPaymentSystem.authentication.User;

public class Ticket {
    private int id;
    private User user;
    private String issue;

    public void setStatus(TicketStatus status) {
        this.status = status;
    }

    private TicketStatus status;

    public Ticket(int id, User user, String issue) {
        this.id = id;
        this.user = user;
        this.issue = issue;
        this.status = TicketStatus.OPEN;
    }


    // getters and setters
}

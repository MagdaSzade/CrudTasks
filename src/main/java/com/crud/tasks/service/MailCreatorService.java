package com.crud.tasks.service;

import com.crud.tasks.config.AdminConfig;
import com.crud.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.ArrayList;
import java.util.List;

@Service
public class MailCreatorService {
    @Autowired
    private AdminConfig adminConfig;
    @Autowired
    @Qualifier("templateEngine")
    private TemplateEngine templateEngine;
    @Autowired
    private TaskRepository taskRepository;

    public String buildTrelloCardEmail(String message) {
        List<String> functionality = new ArrayList<>();
        functionality.add("You can manage your task");
        functionality.add("Provides connection with Trello Account");
        functionality.add("Application allows sending task to Tesllo");
        Context context = getContext();
        context.setVariable("message", message);
        context.setVariable("application_functionality", functionality);
        return templateEngine.process("mail/created-trello-card-mail", context);
    }

    public String scheduledEmail() {
        Context context = getContext();
        context.setVariable("TaskListSize", taskRepository.count());
        return templateEngine.process("mail/scheduled-email", context);
    }

    private Context getContext() {
        Context context = new Context();
        context.setVariable("task_url", "http://localhost:8888/crud");
        context.setVariable("button", "Visit website");
        context.setVariable("admin_name", adminConfig.getAdminName());
        context.setVariable("companyName", adminConfig.getCompanyName());
        context.setVariable("companyGoal", adminConfig.getCompanyGoal());
        context.setVariable("companyPhone", adminConfig.getCompanyPhon());
        context.setVariable("companyEmail", adminConfig.getCompanyEmail());
        context.setVariable("goodby_message", "That's all. Goodbye!");
        context.setVariable("show_button",false);
        context.setVariable("is_friend",false);
        context.setVariable("admin_config", adminConfig);
        return context;
    }
}

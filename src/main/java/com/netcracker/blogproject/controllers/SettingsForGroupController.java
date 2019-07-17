package com.netcracker.blogproject.controllers;

import com.netcracker.blogproject.services.SettingsForGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/topic/{topicId}/article/{articleId}/group")
public class SettingsForGroupController {

    @Autowired
    private SettingsForGroupService settingsForGroupService;

    @RequestMapping(method = RequestMethod.POST, value = "")
    public boolean addSettingsForGroup(@PathVariable int topicId, @PathVariable int articleId,
                                       @RequestBody String[] nicknameAndRights) {
        if(topicId == 0 || articleId == 0 || nicknameAndRights == null) return false;
        return settingsForGroupService.addSettingsForOnePersonInGroup(topicId, articleId, nicknameAndRights);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "")
    public boolean deleteSettingsForGroup(@PathVariable int topicId, @PathVariable int articleId) {
        if(topicId == 0 || articleId == 0) return false;
        return settingsForGroupService.deleteSettingsForOnePersonInGroup(topicId, articleId);
    }

}

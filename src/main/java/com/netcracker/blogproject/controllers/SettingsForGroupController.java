package com.netcracker.blogproject.controllers;

import com.netcracker.blogproject.services.SettingsForGroupService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(value = "SettingsForGroup Controller", description = "Adding and deleting rights(reading, writing and commenting, i.e. \"rwc\") for a group")
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/topic/{topicId}/article/{articleId}/group")
public class SettingsForGroupController {

    @Autowired
    private SettingsForGroupService settingsForGroupService;

    @ApiOperation(value = "Adding rights of one user from the group respectively to the article")
    @RequestMapping(method = RequestMethod.POST, value = "")
    public boolean addSettingsForGroup(@PathVariable int topicId, @PathVariable int articleId,
                                       @RequestBody String[] nicknameAndRights) {
        if(topicId == 0 || articleId == 0 || nicknameAndRights == null) return false;
        return settingsForGroupService.addSettingsForOnePersonInGroup(topicId, articleId, nicknameAndRights);
    }

    @ApiOperation(value = "Deleting rights of all users from the group respectively to the article")
    @RequestMapping(method = RequestMethod.DELETE, value = "")
    public boolean deleteSettingsForGroup(@PathVariable int topicId, @PathVariable int articleId) {
        if(topicId == 0 || articleId == 0) return false;
        return settingsForGroupService.deleteSettingsForOnePersonInGroup(topicId, articleId);
    }

}

package com.kongke.trigger.http;

import com.kongke.domain.chat.model.dto.ChatReq;
import com.kongke.domain.chat.model.vo.GroupChatsVO;
import com.kongke.domain.chat.model.vo.GroupListVO;
import com.kongke.domain.chat.model.vo.GroupMsgVO;
import com.kongke.domain.chat.service.ChatService;
import com.kongke.types.common.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 聊天接口
 *
 * @author kongke
 * @date 2025/05/19
 */
@RequestMapping("/chat")
@RestController
public class ChatController {

    @Autowired
    private ChatService chatService;


    /**
     * 创建群聊
     *
     * @param groupChatsVO 群聊信息
     * @return 创建结果
     */
    @PostMapping("/group/create")
    public Result<Boolean> createGroupChat(@RequestBody GroupChatsVO groupChatsVO) {
        return  Result.success(chatService.createGroupChat(groupChatsVO));
    }

    /**
     * 根据ID获取群聊信息
     *
     * @param gid 群聊ID
     * @return 群聊信息
     */
    @PostMapping("/group/detail")
    public Result<GroupChatsVO> getGroupChatById(@RequestParam("gid") Integer gid) {
        return  Result.success(chatService.getGroupChatById(gid));
    }

    /**
     * 查询群聊
     *
     * @param req 要求
     * @return {@link Result }<{@link List }<{@link GroupListVO }>>
     */
    @PostMapping("/group/query")
    public Result<List<GroupChatsVO>> queryGroup(@RequestBody ChatReq req) {
        return  Result.success(chatService.queryGroup(req));
    }

    /**
     * 更新群聊信息
     *
     * @param groupChatsVO 群聊信息
     * @return 更新结果
     */
    @PostMapping("/group/update")
    public Result<Boolean> updateGroupChat(@RequestBody  GroupChatsVO groupChatsVO) {
        return  Result.success(chatService.updateGroupChat(groupChatsVO));
    }

    /**
     * 删除群聊
     *
     * @param gid 群聊ID
     * @return 删除结果
     */
    @PostMapping("/group/delete")
    public Result<Boolean> deleteGroupChat(@RequestParam("gid") Integer gid) {
        return  Result.success(chatService.deleteGroupChat(gid));
    }


    /**
     * 用户加入群聊
     *
     * @return 操作结果
     */
    @PostMapping("/list/join")
    public Result<Boolean> joinGroup(@RequestBody ChatReq req) {
        return  Result.success(chatService.joinGroup(req));
    }

    /**
     * 用户退出群聊
     *
     * @return 操作结果
     */
    @PostMapping("/list/leave")
    public Result<Boolean> leaveGroup(@RequestBody ChatReq req) {
        return  Result.success(chatService.leaveGroup(req));
    }


    /**
     * 根据用户ID获取其群聊列表
     *
     * @param uid 用户ID
     * @return 用户群聊列表
     */
    @PostMapping("/list/user")
    public Result<List<GroupListVO>> getGroupListByUserId(@RequestParam("uid") Integer uid) {
        return  Result.success(chatService.getGroupListByUserId(uid));
    }




    /**
     * 发送群聊消息
     *
     * @param groupMsgVO 群聊消息
     * @return 发送结果
     */
    @PostMapping("/msg/send")
    public Result<Boolean> sendGroupMessage(@RequestBody GroupMsgVO groupMsgVO) {
        return  Result.success(chatService.sendGroupMessage(groupMsgVO));
    }

    /**
     * 获取指定群聊的消息列表
     *
     * @return 群聊消息列表
     */
    @PostMapping("/msg/list")
    public Result<List<GroupMsgVO>> getGroupMessages(@RequestParam("gid") Integer gid) {
        return  Result.success(chatService.getGroupMessages(gid));
    }

}

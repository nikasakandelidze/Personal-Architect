package service.chatServices;

public interface ChatServiceProvider {
    void sendMessageFromUserToUser(String fromUserId, String toUserId);
    void sendMessageFromUserToGroup(String fromUserId, String toGroupId);
}

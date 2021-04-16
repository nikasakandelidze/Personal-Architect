package service.chatServices;

import model.chat.GroupChat;
import model.chat.PersonalChat;
import org.springframework.stereotype.Service;

@Service
class ChatServiceProviderImpl implements ChatServiceProvider {
    @Override
    public void sendMessageFromUserToUser(String fromUserId, String toUserId) {
        //todo: implement
    }

    @Override
    public void sendMessageFromUserToGroup(String fromUserId, String toGroupId) {
        //todo: implement
    }
}

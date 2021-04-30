package web.requester.groupChat.eventBus;

public class EventBusChatDto {
    private final String from;
    private final String to;

    public EventBusChatDto(String from, String to) {
        this.from = from;
        this.to = to;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    @Override
    public String toString() {
        return "EventBusChatDto{" +
                "from='" + from + '\'' +
                ", to='" + to + '\'' +
                '}';
    }
}

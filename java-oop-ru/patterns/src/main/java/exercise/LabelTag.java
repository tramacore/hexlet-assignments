package exercise;

public class LabelTag implements TagInterface {

    private String tag;
    private TagInterface tagInterface;

    public LabelTag(String tag, TagInterface tagInterface) {
        this.tag = tag;
        this.tagInterface = tagInterface;
    }

    @Override
    public String render() {
        StringBuilder stringBuilder = new StringBuilder("<label>");
        if (tagInterface instanceof InputTag) {
            stringBuilder.append(tag + ((InputTag) tagInterface).render() + "</label>");
            return stringBuilder.toString();
        } else {
            return tagInterface.render();
        }
    }
}

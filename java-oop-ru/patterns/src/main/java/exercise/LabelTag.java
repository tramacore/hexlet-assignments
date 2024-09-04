package exercise;

import javax.swing.plaf.nimbus.State;

public class LabelTag implements TagInterface{

    private String tag;
    private TagInterface tagInterface;

    public LabelTag(String tag, TagInterface tagInterface) {
        this.tag = tag;
        this.tagInterface = tagInterface;
    }

    public void setTagInterface(InputTag inputTag) {

    }

    @Override
    public String render() {
        StringBuilder stringBuilder = new StringBuilder("<label>");
        if (tagInterface instanceof InputTag) {
            stringBuilder.append(tag + ((InputTag)tagInterface).render() + "</label>");
            return stringBuilder.toString();
        } else {
            return tagInterface.render();
        }
    }
}

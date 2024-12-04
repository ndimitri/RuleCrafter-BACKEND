package be.storm.rulecrafterbackend.dal.models.classResponse;

import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProficiencyChoice {
  private String desc;
  private int choose;
  private Options from;

  @Getter
  @Setter
  public static class Options {
    private List<Option> options;

    @Getter
    @Setter
    public static class Option {
      private Item item;

      @Getter
      @Setter
      public static class Item {
        private String name;
        private String url;
        private String index;
      }
    }
  }
}

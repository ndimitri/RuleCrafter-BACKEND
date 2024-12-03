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
    private String option_set_type;
    private List<Options.Option> options;

    @Getter
    @Setter
    public static class Option {
      private String option_type;
      private Options.Option.Item item;

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

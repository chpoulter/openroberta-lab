package de.fhg.iais.roberta.syntax.action.mbot2;

import de.fhg.iais.roberta.blockly.generated.Hide;
import de.fhg.iais.roberta.syntax.BlockType;
import de.fhg.iais.roberta.syntax.BlockTypeContainer;
import de.fhg.iais.roberta.syntax.BlocklyBlockProperties;
import de.fhg.iais.roberta.syntax.BlocklyComment;
import de.fhg.iais.roberta.syntax.BlocklyConstants;
import de.fhg.iais.roberta.syntax.WithUserDefinedPort;
import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.NepoField;
import de.fhg.iais.roberta.transformer.NepoHide;
import de.fhg.iais.roberta.transformer.NepoPhrase;
import de.fhg.iais.roberta.util.dbc.Assert;

@NepoPhrase(containerType = "LEDS_OFF_ACTION")
public class LedsOffAction<V> extends Action<V> implements WithUserDefinedPort<V> {
    @NepoField(name = BlocklyConstants.ACTORPORT, value = BlocklyConstants.EMPTY_PORT)
    public final String port;
    @NepoField(name = BlocklyConstants.LED, value = BlocklyConstants.EMPTY_PORT)
    public final String led;
    @NepoHide
    public final Hide hide;

    public LedsOffAction(BlockType kind, BlocklyBlockProperties properties, BlocklyComment comment, String port, String led, Hide hide) {
        super(kind, properties, comment);
        Assert.nonEmptyString(port);
        Assert.notNull(led);
        this.hide = hide;
        this.port = port;
        this.led = led;
        setReadOnly();
    }

    /**
     * Creates instance of {@link LedsOffAction}. This instance is read only and can not be modified.
     *
     * @param properties of the block (see {@link BlocklyBlockProperties}),
     * @param comment added from the user,
     * @return read only object of class {@link LedsOffAction}
     */
    public static <V> LedsOffAction<V> make(BlocklyBlockProperties properties, BlocklyComment comment, String port, String led, Hide hide) {
        return new LedsOffAction<>(BlockTypeContainer.getByName("LEDS_OFF_ACTION"), properties, comment, port,led, hide);
    }


    public String getLed(){
        return this.led;
    }

    @Override
    public String getUserDefinedPort() {
        return this.port;
    }
}

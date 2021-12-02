package de.fhg.iais.roberta.syntax.sensor.mbot2;

import de.fhg.iais.roberta.blockly.generated.Block;
import de.fhg.iais.roberta.blockly.generated.Mutation;
import de.fhg.iais.roberta.syntax.BlockType;
import de.fhg.iais.roberta.syntax.BlockTypeContainer;
import de.fhg.iais.roberta.syntax.BlocklyBlockProperties;
import de.fhg.iais.roberta.syntax.BlocklyComment;
import de.fhg.iais.roberta.syntax.BlocklyConstants;
import de.fhg.iais.roberta.syntax.Phrase;
import de.fhg.iais.roberta.syntax.WithUserDefinedPort;
import de.fhg.iais.roberta.syntax.sensor.ExternalSensor;
import de.fhg.iais.roberta.syntax.sensor.Sensor;
import de.fhg.iais.roberta.syntax.sensor.SensorMetaDataBean;
import de.fhg.iais.roberta.transformer.Jaxb2Ast;
import de.fhg.iais.roberta.transformer.Jaxb2ProgramAst;
import de.fhg.iais.roberta.transformer.NepoField;
import de.fhg.iais.roberta.transformer.NepoMutation;
import de.fhg.iais.roberta.transformer.NepoPhrase;

@NepoPhrase(containerType = "QUAD_COLOR_SENSING")
public class QuadRGBSensor<V> extends Sensor<V> implements WithUserDefinedPort<V> {
    @NepoMutation(fieldName = BlocklyConstants.MODE)
    public final Mutation mutation;
    @NepoField(name = BlocklyConstants.MODE)
    public final String mode;
    @NepoField(name = BlocklyConstants.SENSORPORT)
    public final String sensorPort;
    @NepoField(name = BlocklyConstants.SLOT)
    public final String slot;

    public QuadRGBSensor(BlockType kind, BlocklyBlockProperties properties, BlocklyComment comment, Mutation mutation, String mode, String sensorPort, String slot) {
        super(kind, properties, comment);
        this.mutation = mutation;
        this.mode = mode;
        this.sensorPort = sensorPort;
        this.slot = slot;
        setReadOnly();
    }

    @Override
    public String getUserDefinedPort() {
        return this.sensorPort;
    }

}

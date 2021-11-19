package de.fhg.iais.roberta.syntax.action.mbot2;

import java.util.List;

import de.fhg.iais.roberta.blockly.generated.Block;
import de.fhg.iais.roberta.blockly.generated.Field;
import de.fhg.iais.roberta.syntax.BlockTypeContainer;
import de.fhg.iais.roberta.syntax.BlocklyBlockProperties;
import de.fhg.iais.roberta.syntax.BlocklyComment;
import de.fhg.iais.roberta.syntax.BlocklyConstants;
import de.fhg.iais.roberta.syntax.Phrase;
import de.fhg.iais.roberta.syntax.WithUserDefinedPort;
import de.fhg.iais.roberta.syntax.action.Action;
import de.fhg.iais.roberta.transformer.Ast2Jaxb;
import de.fhg.iais.roberta.transformer.Jaxb2Ast;
import de.fhg.iais.roberta.transformer.Jaxb2ProgramAst;
import de.fhg.iais.roberta.util.dbc.Assert;

/**
 * This class represents the <b>robActions_play_recording</b> block from Blockly into the AST (abstract syntax tree). Object from this class will generate code for
 * stopping every movement of the robot.<br/>
 * <br/>
 */
public final class PlayRecordingAction<V> extends Action<V> implements WithUserDefinedPort<V> {
    private final String port;

    private PlayRecordingAction(BlocklyBlockProperties properties, BlocklyComment comment, String port) {
        super(BlockTypeContainer.getByName("PLAY_RECORDING_ACTION"), properties, comment);
        Assert.notNull(port);
        this.port = port;
        setReadOnly();
    }

    /**
     * Creates instance of {@link PlayRecordingAction}. This instance is read only and can not be modified.
     *
     * @param properties of the block (see {@link BlocklyBlockProperties}),
     * @param comment added from the user,
     * @return read only object of class {@link PlayRecordingAction}
     */
    private static <V> PlayRecordingAction<V> make(BlocklyBlockProperties properties, BlocklyComment comment, String port) {
        return new PlayRecordingAction<>(properties, comment, port);
    }

    @Override
    public String getUserDefinedPort() {
        return this.port;
    }

    @Override
    public String toString() {
        return "PlayRecording []";
    }

    /**
     * Transformation from JAXB object to corresponding AST object.
     *
     * @param block for transformation
     * @param helper class for making the transformation
     * @return corresponding AST object
     */
    public static <V> Phrase<V> jaxbToAst(Block block, Jaxb2ProgramAst<V> helper) {
        List<Field> fields = Jaxb2Ast.extractFields(block, (short) 2);
        String port = Jaxb2Ast.extractField(fields, BlocklyConstants.ACTORPORT);

        return PlayRecordingAction.make(Jaxb2Ast.extractBlockProperties(block), Jaxb2Ast.extractComment(block), port);
    }

    @Override
    public Block astToBlock() {
        Block jaxbDestination = new Block();
        Ast2Jaxb.setBasicProperties(this, jaxbDestination);
        Ast2Jaxb.addField(jaxbDestination, BlocklyConstants.ACTORPORT, this.port);
        return jaxbDestination;
    }
}

package com.intuit.dsl.expression.runtime.evaluator;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Consumer;
import org.eclipse.emf.ecore.EObject;
import com.intuit.dsl.expression.AddToDate;
import com.intuit.dsl.expression.ArithmeticSigned;
import com.intuit.dsl.expression.BooleanExpression;
import com.intuit.dsl.expression.BooleanLiteral;
import com.intuit.dsl.expression.BooleanNegation;
import com.intuit.dsl.expression.CollectionFunction;
import com.intuit.dsl.expression.CollectionFunctionCall;
import com.intuit.dsl.expression.Comparison;
import com.intuit.dsl.expression.ConcatFunc;
import com.intuit.dsl.expression.Contains;
import com.intuit.dsl.expression.CurrentDate;
import com.intuit.dsl.expression.DateFormat;
import com.intuit.dsl.expression.DayDifference;
import com.intuit.dsl.expression.DedupFunc;
import com.intuit.dsl.expression.Delete;
import com.intuit.dsl.expression.Equals;
import com.intuit.dsl.expression.Expression;
import com.intuit.dsl.expression.Extract;
import com.intuit.dsl.expression.FilterFunc;
import com.intuit.dsl.expression.FindFirstFunc;
import com.intuit.dsl.expression.Function;
import com.intuit.dsl.expression.FunctionReference;
import com.intuit.dsl.expression.Join;
import com.intuit.dsl.expression.Json;
import com.intuit.dsl.expression.Key;
import com.intuit.dsl.expression.LastFunc;
import com.intuit.dsl.expression.Length;
import com.intuit.dsl.expression.LowerFunc;
import com.intuit.dsl.expression.MapFunc;
import com.intuit.dsl.expression.MapStatement;
import com.intuit.dsl.expression.Membership;
import com.intuit.dsl.expression.Minus;
import com.intuit.dsl.expression.MultiOrDivOrMod;
import com.intuit.dsl.expression.NullLiteral;
import com.intuit.dsl.expression.NumberLiteral;
import com.intuit.dsl.expression.ParentFunc;
import com.intuit.dsl.expression.PickFirst;
import com.intuit.dsl.expression.Plus;
import com.intuit.dsl.expression.Property;
import com.intuit.dsl.expression.PropertyExpresssion;
import com.intuit.dsl.expression.Range;
import com.intuit.dsl.expression.RemoveFunc;
import com.intuit.dsl.expression.SchemaVariable;
import com.intuit.dsl.expression.SortFunc;
import com.intuit.dsl.expression.Split;
import com.intuit.dsl.expression.StringLiteral;
import com.intuit.dsl.expression.TernaryExpression;
import com.intuit.dsl.expression.TranslateUnicode;
import com.intuit.dsl.expression.UUIDFunc;
import com.intuit.dsl.expression.UpperFunc;
import com.intuit.dsl.expression.Variable;
import com.intuit.dsl.expression.VariableReference;
import com.intuit.dsl.expression.runtime.ConfigManager;
import com.intuit.dsl.expression.runtime.evaluator.config.PropertyEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.config.PropertyExpresssionEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.AddToDateEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.CollectionFunctionEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.ConcatFuncEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.ContainsEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.CurrentDateEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.DateFormatEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.DayDifferenceEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.DedupFuncEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.DeleteEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.ExtractEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.FilterFuncEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.FindFirstFuncEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.FunctionReferenceEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.JoinEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.JsonEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.LastFuncEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.LengthEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.LowerFuncEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.MapFuncEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.ParentFuncEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.PickFirstEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.RemoveFuncEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.SortFuncEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.SplitEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.TernaryExpressionEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.TranslateUnicodeEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.UUIDFuncEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.function.UpperFuncEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.operation.ArithmeticSignedEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.operation.BooleanExpressionEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.operation.BooleanNegationEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.operation.ComparisonEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.operation.EqualsEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.operation.MembershipEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.operation.MinusEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.operation.MultiOrDivOrModEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.operation.PlusEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.variables.LiteralEvaluators;
import com.intuit.dsl.expression.runtime.evaluator.variables.SchemaVariableEvaluator;
import com.intuit.dsl.expression.runtime.evaluator.variables.VariableReferenceEvaluator;
import com.intuit.dsl.expression.runtime.model.DataModel;
import com.intuit.dsl.expression.runtime.model.DataValue;
import com.intuit.dsl.expression.runtime.model.RuntimeOptions;
import com.intuit.dsl.expression.util.ExpressionSwitch;
import lombok.Getter;

@Getter
public class ExpressionEvaluator extends ExpressionSwitch<DataValue> {

  public DataValue caseExpression(Expression object) {
    return doSwitch(object);
  }

  public DataValue caseVariable(Variable object) {
    return doSwitch(object.getSchemaVariable());
  }

  public DataValue caseKey(Key object) {
    return null;
  }

  public DataValue caseSchemaVariable(SchemaVariable object) {
    return new SchemaVariableEvaluator(this).evaluate(object);
  }

  public DataValue caseProperty(Property object) {
    return new PropertyEvaluator(this).evaluate(object);
  }

  public DataValue caseTernaryExpression(TernaryExpression object) {
    return new TernaryExpressionEvaluator(this).evaluate(object);
  }

  public DataValue caseFunction(Function object) {
    return null;
  }

  public DataValue caseCollectionFunction(CollectionFunction object) {
    return new CollectionFunctionEvaluator(this).evaluate(object);
  }

  public DataValue caseCollectionFunctionCall(CollectionFunctionCall object) {
    return null;
  }

  public DataValue caseParentFunc(ParentFunc object) {
    return new ParentFuncEvaluator(this).evaluate(object);
  }

  public DataValue caseLastFunc(LastFunc object) {
    return new LastFuncEvaluator(this).evaluate(object);
  }

  public DataValue caseDelete(Delete object) {
    return new DeleteEvaluator(this).evaluate(object);
  }

  public DataValue caseSplit(Split object) {
    return new SplitEvaluator(this).evaluate(object);
  }

  public DataValue caseContains(Contains object) {
    return new ContainsEvaluator(this).evaluate(object);
  }

  public DataValue caseExtract(Extract object) {
    return new ExtractEvaluator(this).evaluate(object);
  }

  public DataValue caseDateFormat(DateFormat object) {
    return new DateFormatEvaluator(this).evaluate(object);
  }

  public DataValue caseAddToDate(AddToDate object) {
    return new AddToDateEvaluator(this).evaluate(object);
  }

  public DataValue caseFilterFunc(FilterFunc object) {
    return new FilterFuncEvaluator(this).evaluate(object);
  }

  public DataValue caseFindFirstFunc(FindFirstFunc object) {
    return new FindFirstFuncEvaluator(this).evaluate(object);
  }

  public DataValue caseRemoveFunc(RemoveFunc object) {
    return new RemoveFuncEvaluator(this).evaluate(object);
  }

  public DataValue caseSortFunc(SortFunc object) {
    return new SortFuncEvaluator(this).evaluate(object);
  }

  public DataValue caseDedupFunc(DedupFunc object) {
    return new DedupFuncEvaluator(this).evaluate(object);
  }

  public DataValue caseMapFunc(MapFunc object) {
    return new MapFuncEvaluator(this).evaluate(object);
  }

  public DataValue caseRange(Range object) {
    return null;
  }

  public DataValue caseMapStatement(MapStatement object) {
    return null;
  }

  public DataValue caseConcatFunc(ConcatFunc object) {
    return new ConcatFuncEvaluator(this).evaluate(object);
  }

  public DataValue caseLength(Length object) {
    return new LengthEvaluator(this).evaluate(object);
  }

  public DataValue caseLowerFunc(LowerFunc object) {
    return new LowerFuncEvaluator(this).evaluate(object);
  }

  public DataValue caseUpperFunc(UpperFunc object) {
    return new UpperFuncEvaluator(this).evaluate(object);
  }

  public DataValue caseUUIDFunc(UUIDFunc object) {
    return new UUIDFuncEvaluator(this).evaluate(object);
  }

  public DataValue caseJson(Json object) {
    return new JsonEvaluator(this).evaluate(object);
  }

  public DataValue caseJoin(Join object) {
    return new JoinEvaluator(this).evaluate(object);
  }

  public DataValue caseDayDifference(DayDifference object) {
    return new DayDifferenceEvaluator(this).evaluate(object);
  }

  public DataValue caseTranslateUnicode(TranslateUnicode object) {
    return new TranslateUnicodeEvaluator(this).evaluate(object);
  }

  public DataValue caseCurrentDate(CurrentDate object) {
    return new CurrentDateEvaluator(this).evaluate(object);
  }

  public DataValue casePickFirst(PickFirst object) {
    return new PickFirstEvaluator(this).evaluate(object);
  }

  public DataValue caseBooleanExpression(BooleanExpression object) {
    return new BooleanExpressionEvaluator(this).evaluate(object);
  }

  public DataValue caseComparison(Comparison object) {
    return new ComparisonEvaluator(this).evaluate(object);
  }

  public DataValue caseMembership(Membership object) {
    return new MembershipEvaluator(this).evaluate(object);
  }

  public DataValue caseEquals(Equals object) {
    return new EqualsEvaluator(this).evaluate(object);
  }

  public DataValue casePlus(Plus object) {
    return new PlusEvaluator(this).evaluate(object);
  }

  public DataValue caseMinus(Minus object) {
    return new MinusEvaluator(this).evaluate(object);
  }

  public DataValue caseMultiOrDivOrMod(MultiOrDivOrMod object) {
    return new MultiOrDivOrModEvaluator(this).evaluate(object);
  }

  public DataValue caseBooleanNegation(BooleanNegation object) {
    return new BooleanNegationEvaluator(this).evaluate(object);
  }

  public DataValue caseArithmeticSigned(ArithmeticSigned object) {
    return new ArithmeticSignedEvaluator(this).evaluate(object);
  }

  public DataValue caseNumberLiteral(NumberLiteral object) {
    return LiteralEvaluators.NUMBER_LITERAL.evaluate(object);
  }

  public DataValue caseStringLiteral(StringLiteral object) {
    return LiteralEvaluators.STRING_LITERAL.evaluate(object);
  }

  public DataValue caseFunctionReference(FunctionReference object) {
    return new FunctionReferenceEvaluator(this).evaluate(object);

  }

  public DataValue caseNullLiteral(NullLiteral object) {
    return LiteralEvaluators.NULL_LITERAL.evaluate(object);
  }

  public DataValue caseBooleanLiteral(BooleanLiteral object) {
    return LiteralEvaluators.BOOLEAN_LITERAL.evaluate(object);
  }

  public DataValue caseVariableReference(VariableReference object) {
    return new VariableReferenceEvaluator(this).evaluate(object);

  }

  public DataValue casePropertyExpresssion(PropertyExpresssion object) {
    return new PropertyExpresssionEvaluator(this).evaluate(object);

  }

  public DataValue defaultCase(EObject object) {
    return null;
  }

  private Optional<ExpressionEvaluator> parentVisitor;
  private RuntimeOptions runtimeOptions;
  private ConfigManager configManager;
  private Map<String, DataModel> inputs;

  private ExpressionEvaluator(final Builder builder) {
    parentVisitor = builder.parentVisitor;
    runtimeOptions = builder.runtimeOptions;
    configManager = builder.configManager;
    inputs = builder.inputs;
  }

  public static Builder newExpressionEvaluator() {
    return new Builder();
  }

  public static Builder newExpressionEvaluator(final ExpressionEvaluator copy) {
    Builder builder = new Builder();
    builder.parentVisitor = copy.parentVisitor;
    builder.runtimeOptions = copy.runtimeOptions;
    builder.configManager = copy.configManager;
    builder.inputs = copy.inputs;
    return builder;
  }

  public ExpressionEvaluator transform(final Consumer<Builder> builderConsumer) {
    Builder builder = newExpressionEvaluator(this);
    builderConsumer.accept(builder);
    return builder.build();
  }

  public static final class Builder {

    private Optional<ExpressionEvaluator> parentVisitor = Optional.empty();
    private RuntimeOptions runtimeOptions = new RuntimeOptions();
    private ConfigManager configManager = new ConfigManager() {};
    private Map<String, DataModel> inputs = new HashMap<>();

    private Builder() {}

    public Builder withParentVisitor(final ExpressionEvaluator parentVisitor) {
      this.parentVisitor = Optional.of(parentVisitor);
      return this;
    }

    public Builder withOptions(final RuntimeOptions runtimeOptions) {
      this.runtimeOptions = runtimeOptions;
      return this;
    }

    public Builder withConfigManager(final ConfigManager configManager) {
      this.configManager = configManager;
      return this;
    }

    public Builder withInputs(final Map<String, DataModel> inputs) {
      this.inputs = inputs;
      return this;
    }

    public ExpressionEvaluator build() {
      return new ExpressionEvaluator(this);
    }
  }
}

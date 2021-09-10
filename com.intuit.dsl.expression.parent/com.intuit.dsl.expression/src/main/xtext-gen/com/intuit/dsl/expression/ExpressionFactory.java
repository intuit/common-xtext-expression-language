/**
 * generated by Xtext 2.25.0
 */
package com.intuit.dsl.expression;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see com.intuit.dsl.expression.ExpressionPackage
 * @generated
 */
public interface ExpressionFactory extends EFactory
{
  /**
   * The singleton instance of the factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @generated
   */
  ExpressionFactory eINSTANCE = com.intuit.dsl.expression.impl.ExpressionFactoryImpl.init();

  /**
   * Returns a new object of class '<em>Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Expression</em>'.
   * @generated
   */
  Expression createExpression();

  /**
   * Returns a new object of class '<em>Literal Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Literal Expression</em>'.
   * @generated
   */
  LiteralExpression createLiteralExpression();

  /**
   * Returns a new object of class '<em>Ternary Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Ternary Expression</em>'.
   * @generated
   */
  TernaryExpression createTernaryExpression();

  /**
   * Returns a new object of class '<em>Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function</em>'.
   * @generated
   */
  Function createFunction();

  /**
   * Returns a new object of class '<em>Collection Function</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Collection Function</em>'.
   * @generated
   */
  CollectionFunction createCollectionFunction();

  /**
   * Returns a new object of class '<em>Collection Function Call</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Collection Function Call</em>'.
   * @generated
   */
  CollectionFunctionCall createCollectionFunctionCall();

  /**
   * Returns a new object of class '<em>Parent Func</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Parent Func</em>'.
   * @generated
   */
  ParentFunc createParentFunc();

  /**
   * Returns a new object of class '<em>Last Func</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Last Func</em>'.
   * @generated
   */
  LastFunc createLastFunc();

  /**
   * Returns a new object of class '<em>Delete</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Delete</em>'.
   * @generated
   */
  Delete createDelete();

  /**
   * Returns a new object of class '<em>Split</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Split</em>'.
   * @generated
   */
  Split createSplit();

  /**
   * Returns a new object of class '<em>Contains</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Contains</em>'.
   * @generated
   */
  Contains createContains();

  /**
   * Returns a new object of class '<em>Extract</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Extract</em>'.
   * @generated
   */
  Extract createExtract();

  /**
   * Returns a new object of class '<em>Date Format</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Date Format</em>'.
   * @generated
   */
  DateFormat createDateFormat();

  /**
   * Returns a new object of class '<em>Add To Date</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Add To Date</em>'.
   * @generated
   */
  AddToDate createAddToDate();

  /**
   * Returns a new object of class '<em>Filter Func</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Filter Func</em>'.
   * @generated
   */
  FilterFunc createFilterFunc();

  /**
   * Returns a new object of class '<em>Find First Func</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Find First Func</em>'.
   * @generated
   */
  FindFirstFunc createFindFirstFunc();

  /**
   * Returns a new object of class '<em>Remove Func</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Remove Func</em>'.
   * @generated
   */
  RemoveFunc createRemoveFunc();

  /**
   * Returns a new object of class '<em>Sort Func</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Sort Func</em>'.
   * @generated
   */
  SortFunc createSortFunc();

  /**
   * Returns a new object of class '<em>Dedup Func</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Dedup Func</em>'.
   * @generated
   */
  DedupFunc createDedupFunc();

  /**
   * Returns a new object of class '<em>Map Func</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Map Func</em>'.
   * @generated
   */
  MapFunc createMapFunc();

  /**
   * Returns a new object of class '<em>Range</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Range</em>'.
   * @generated
   */
  Range createRange();

  /**
   * Returns a new object of class '<em>Map Statement</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Map Statement</em>'.
   * @generated
   */
  MapStatement createMapStatement();

  /**
   * Returns a new object of class '<em>Concat Func</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Concat Func</em>'.
   * @generated
   */
  ConcatFunc createConcatFunc();

  /**
   * Returns a new object of class '<em>Length</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Length</em>'.
   * @generated
   */
  Length createLength();

  /**
   * Returns a new object of class '<em>Lower Func</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Lower Func</em>'.
   * @generated
   */
  LowerFunc createLowerFunc();

  /**
   * Returns a new object of class '<em>Upper Func</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Upper Func</em>'.
   * @generated
   */
  UpperFunc createUpperFunc();

  /**
   * Returns a new object of class '<em>UUID Func</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>UUID Func</em>'.
   * @generated
   */
  UUIDFunc createUUIDFunc();

  /**
   * Returns a new object of class '<em>Json</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Json</em>'.
   * @generated
   */
  Json createJson();

  /**
   * Returns a new object of class '<em>Join</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Join</em>'.
   * @generated
   */
  Join createJoin();

  /**
   * Returns a new object of class '<em>Day Difference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Day Difference</em>'.
   * @generated
   */
  DayDifference createDayDifference();

  /**
   * Returns a new object of class '<em>Translate Unicode</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Translate Unicode</em>'.
   * @generated
   */
  TranslateUnicode createTranslateUnicode();

  /**
   * Returns a new object of class '<em>Current Date</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Current Date</em>'.
   * @generated
   */
  CurrentDate createCurrentDate();

  /**
   * Returns a new object of class '<em>Pick First</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Pick First</em>'.
   * @generated
   */
  PickFirst createPickFirst();

  /**
   * Returns a new object of class '<em>Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable</em>'.
   * @generated
   */
  Variable createVariable();

  /**
   * Returns a new object of class '<em>Key</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Key</em>'.
   * @generated
   */
  Key createKey();

  /**
   * Returns a new object of class '<em>Schema Variable</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Schema Variable</em>'.
   * @generated
   */
  SchemaVariable createSchemaVariable();

  /**
   * Returns a new object of class '<em>Property</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property</em>'.
   * @generated
   */
  Property createProperty();

  /**
   * Returns a new object of class '<em>Boolean Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Expression</em>'.
   * @generated
   */
  BooleanExpression createBooleanExpression();

  /**
   * Returns a new object of class '<em>Comparison</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Comparison</em>'.
   * @generated
   */
  Comparison createComparison();

  /**
   * Returns a new object of class '<em>Membership</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Membership</em>'.
   * @generated
   */
  Membership createMembership();

  /**
   * Returns a new object of class '<em>Equals</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Equals</em>'.
   * @generated
   */
  Equals createEquals();

  /**
   * Returns a new object of class '<em>Plus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Plus</em>'.
   * @generated
   */
  Plus createPlus();

  /**
   * Returns a new object of class '<em>Minus</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Minus</em>'.
   * @generated
   */
  Minus createMinus();

  /**
   * Returns a new object of class '<em>Multi Or Div Or Mod</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Multi Or Div Or Mod</em>'.
   * @generated
   */
  MultiOrDivOrMod createMultiOrDivOrMod();

  /**
   * Returns a new object of class '<em>Boolean Negation</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Negation</em>'.
   * @generated
   */
  BooleanNegation createBooleanNegation();

  /**
   * Returns a new object of class '<em>Arithmetic Signed</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Arithmetic Signed</em>'.
   * @generated
   */
  ArithmeticSigned createArithmeticSigned();

  /**
   * Returns a new object of class '<em>Function Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Function Reference</em>'.
   * @generated
   */
  FunctionReference createFunctionReference();

  /**
   * Returns a new object of class '<em>Variable Reference</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Variable Reference</em>'.
   * @generated
   */
  VariableReference createVariableReference();

  /**
   * Returns a new object of class '<em>Property Expresssion</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Property Expresssion</em>'.
   * @generated
   */
  PropertyExpresssion createPropertyExpresssion();

  /**
   * Returns a new object of class '<em>Number Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Number Literal</em>'.
   * @generated
   */
  NumberLiteral createNumberLiteral();

  /**
   * Returns a new object of class '<em>String Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>String Literal</em>'.
   * @generated
   */
  StringLiteral createStringLiteral();

  /**
   * Returns a new object of class '<em>Null Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Null Literal</em>'.
   * @generated
   */
  NullLiteral createNullLiteral();

  /**
   * Returns a new object of class '<em>Boolean Literal</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Boolean Literal</em>'.
   * @generated
   */
  BooleanLiteral createBooleanLiteral();

  /**
   * Returns a new object of class '<em>Array Expression</em>'.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return a new object of class '<em>Array Expression</em>'.
   * @generated
   */
  ArrayExpression createArrayExpression();

  /**
   * Returns the package supported by this factory.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the package supported by this factory.
   * @generated
   */
  ExpressionPackage getExpressionPackage();

} //ExpressionFactory
/**
 * generated by Xtext 2.25.0
 */
package com.intuit.dsl.expression;

import java.math.BigDecimal;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Number Literal</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.intuit.dsl.expression.NumberLiteral#getValue <em>Value</em>}</li>
 * </ul>
 *
 * @see com.intuit.dsl.expression.ExpressionPackage#getNumberLiteral()
 * @model
 * @generated
 */
public interface NumberLiteral extends LiteralExpression
{
  /**
   * Returns the value of the '<em><b>Value</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Value</em>' attribute.
   * @see #setValue(BigDecimal)
   * @see com.intuit.dsl.expression.ExpressionPackage#getNumberLiteral_Value()
   * @model
   * @generated
   */
  BigDecimal getValue();

  /**
   * Sets the value of the '{@link com.intuit.dsl.expression.NumberLiteral#getValue <em>Value</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Value</em>' attribute.
   * @see #getValue()
   * @generated
   */
  void setValue(BigDecimal value);

} // NumberLiteral
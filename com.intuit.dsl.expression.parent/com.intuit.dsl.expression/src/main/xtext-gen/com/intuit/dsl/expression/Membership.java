/**
 * generated by Xtext 2.25.0
 */
package com.intuit.dsl.expression;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Membership</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.intuit.dsl.expression.Membership#getLeft <em>Left</em>}</li>
 *   <li>{@link com.intuit.dsl.expression.Membership#getOp <em>Op</em>}</li>
 *   <li>{@link com.intuit.dsl.expression.Membership#getRight <em>Right</em>}</li>
 * </ul>
 *
 * @see com.intuit.dsl.expression.ExpressionPackage#getMembership()
 * @model
 * @generated
 */
public interface Membership extends Expression
{
  /**
   * Returns the value of the '<em><b>Left</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Left</em>' containment reference.
   * @see #setLeft(Expression)
   * @see com.intuit.dsl.expression.ExpressionPackage#getMembership_Left()
   * @model containment="true"
   * @generated
   */
  Expression getLeft();

  /**
   * Sets the value of the '{@link com.intuit.dsl.expression.Membership#getLeft <em>Left</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Left</em>' containment reference.
   * @see #getLeft()
   * @generated
   */
  void setLeft(Expression value);

  /**
   * Returns the value of the '<em><b>Op</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Op</em>' attribute.
   * @see #setOp(String)
   * @see com.intuit.dsl.expression.ExpressionPackage#getMembership_Op()
   * @model
   * @generated
   */
  String getOp();

  /**
   * Sets the value of the '{@link com.intuit.dsl.expression.Membership#getOp <em>Op</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Op</em>' attribute.
   * @see #getOp()
   * @generated
   */
  void setOp(String value);

  /**
   * Returns the value of the '<em><b>Right</b></em>' containment reference list.
   * The list contents are of type {@link com.intuit.dsl.expression.Expression}.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Right</em>' containment reference list.
   * @see com.intuit.dsl.expression.ExpressionPackage#getMembership_Right()
   * @model containment="true"
   * @generated
   */
  EList<Expression> getRight();

} // Membership
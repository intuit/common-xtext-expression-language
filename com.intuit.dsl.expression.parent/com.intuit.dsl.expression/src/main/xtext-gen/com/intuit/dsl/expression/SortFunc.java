/**
 * generated by Xtext 2.25.0
 */
package com.intuit.dsl.expression;


/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Sort Func</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link com.intuit.dsl.expression.SortFunc#getExp <em>Exp</em>}</li>
 *   <li>{@link com.intuit.dsl.expression.SortFunc#getKey <em>Key</em>}</li>
 *   <li>{@link com.intuit.dsl.expression.SortFunc#getType <em>Type</em>}</li>
 * </ul>
 *
 * @see com.intuit.dsl.expression.ExpressionPackage#getSortFunc()
 * @model
 * @generated
 */
public interface SortFunc extends CollectionFunctionCall
{
  /**
   * Returns the value of the '<em><b>Exp</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Exp</em>' containment reference.
   * @see #setExp(Expression)
   * @see com.intuit.dsl.expression.ExpressionPackage#getSortFunc_Exp()
   * @model containment="true"
   * @generated
   */
  Expression getExp();

  /**
   * Sets the value of the '{@link com.intuit.dsl.expression.SortFunc#getExp <em>Exp</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Exp</em>' containment reference.
   * @see #getExp()
   * @generated
   */
  void setExp(Expression value);

  /**
   * Returns the value of the '<em><b>Key</b></em>' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Key</em>' containment reference.
   * @see #setKey(SchemaVariable)
   * @see com.intuit.dsl.expression.ExpressionPackage#getSortFunc_Key()
   * @model containment="true"
   * @generated
   */
  SchemaVariable getKey();

  /**
   * Sets the value of the '{@link com.intuit.dsl.expression.SortFunc#getKey <em>Key</em>}' containment reference.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Key</em>' containment reference.
   * @see #getKey()
   * @generated
   */
  void setKey(SchemaVariable value);

  /**
   * Returns the value of the '<em><b>Type</b></em>' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @return the value of the '<em>Type</em>' attribute.
   * @see #setType(String)
   * @see com.intuit.dsl.expression.ExpressionPackage#getSortFunc_Type()
   * @model
   * @generated
   */
  String getType();

  /**
   * Sets the value of the '{@link com.intuit.dsl.expression.SortFunc#getType <em>Type</em>}' attribute.
   * <!-- begin-user-doc -->
   * <!-- end-user-doc -->
   * @param value the new value of the '<em>Type</em>' attribute.
   * @see #getType()
   * @generated
   */
  void setType(String value);

} // SortFunc
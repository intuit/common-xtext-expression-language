package com.intuit.dsl.tests

import com.google.inject.Inject
import com.google.inject.Provider
import com.intuit.dsl.expression.Expression
import java.io.IOException
import org.eclipse.emf.common.util.URI
import org.eclipse.emf.ecore.resource.Resource
import org.eclipse.xtext.resource.XtextResourceSet
import org.eclipse.xtext.testing.InjectWith
import org.eclipse.xtext.testing.extensions.InjectionExtension
import org.eclipse.xtext.testing.util.ParseHelper
import org.eclipse.xtext.testing.validation.ValidationTestHelper
import org.eclipse.xtext.util.StringInputStream
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.^extension.ExtendWith

@ExtendWith(InjectionExtension)
@InjectWith(ExpressionInjectorProvider)
abstract class AbstractExpressionTestCase extends Assertions {

	@Inject
	ParseHelper<Expression> parserHelper

	@Inject
	ValidationTestHelper validationHelper

	@Inject
	Provider<XtextResourceSet> resourceSetProvider

	def Expression expression(CharSequence string) throws Exception {
		return expression(string, false)
	}

	def Expression expression(CharSequence string, boolean resolve) throws Exception {
		val parse = parserHelper.parse(string)
		if (resolve)
			validationHelper.assertNoErrors(parse)
		return parse
	}

	def Resource newResource(CharSequence input) throws IOException {
		val set = newXtextResourceSet()
		val resource = set.createResource(URI.createURI("Test.___expression"))
		resource.load(new StringInputStream(input.toString()), null)
		return resource
	}

	def XtextResourceSet newXtextResourceSet() {
		return resourceSetProvider.get()
	}

}

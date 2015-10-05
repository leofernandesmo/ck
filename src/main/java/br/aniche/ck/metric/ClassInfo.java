package br.aniche.ck.metric;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.EnumDeclaration;
import org.eclipse.jdt.core.dom.ITypeBinding;
import org.eclipse.jdt.core.dom.TypeDeclaration;

public class ClassInfo extends ASTVisitor {

	private String className;

	@Override
	public boolean visit(TypeDeclaration node) {
		ITypeBinding binding = node.resolveBinding();

		this.className = binding.getBinaryName();
		return false;
	}
	
	@Override
	public boolean visit(EnumDeclaration node) {
		
		this.className = node.resolveBinding().getBinaryName();
		
		return false;
	}
	
	public String getClassName() {
		return className;
	}
}

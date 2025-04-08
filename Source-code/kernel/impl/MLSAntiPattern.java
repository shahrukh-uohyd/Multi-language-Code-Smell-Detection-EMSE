
package mlssdd.kernel.impl;

import java.util.Arrays;
import java.util.List;

public class MLSAntiPattern {

	private String antiPatternName;

	private String variableName;
	private String methodName;
	private String className;
	private String packageName;
	private String filePath;

	public MLSAntiPattern(final String aMethod, final String aClass) {
		this.methodName = aMethod;
		this.className = aClass;
	}

	public MLSAntiPattern(
		final String anAntiPattern,
		final String aVariable,
		final String aMethod,
		final String aClass,
		final String aPackage,
		final String aPath) {
		this.antiPatternName = anAntiPattern;
		this.variableName = aVariable;
		this.methodName = aMethod;
		this.className = aClass;
		this.packageName = aPackage;
		this.filePath = aPath;
	}

	@Override
	public boolean equals(final Object o) {
		if (o == null) {
			return false;
		}

		if (!(o instanceof MLSAntiPattern)) {
			return false;
		}

		if (o == this) {
			return true;
		}

		return this
			.getElementsList()
			.equals(((MLSAntiPattern) o).getElementsList());
	}

	public String getAntiPatternName() {
		return this.antiPatternName;
	}

	public String getClassName() {
		return this.className;
	}

	protected List<String> getElementsList() {
		return Arrays
			.asList(
				this.packageName,
				this.className,
				this.methodName,
				this.variableName,
				//modification--adding filepath
				this.filePath);
	}

	public String getFileName() {
		final String[] parts = this.filePath.split("[\\/\\\\]");
		return parts[parts.length - 1];
	}

	public String getFilePath() {
		return this.filePath;
	}

	public String getMethodName() {
		return this.methodName;
	}

	public String getPackageName() {
		return this.packageName;
	}

	public String getVariableName() {
		return this.variableName;
	}

	@Override
	public int hashCode() {
		return this.getElementsList().hashCode();
	}

	public void setAntiPatternName(final String antiPatternName) {
		this.antiPatternName = antiPatternName;
	}

	public void setClassName(final String className) {
		this.className = className;
	}

	public void setFilePath(final String filePath) {
		this.filePath = filePath;
	}

	public void setMethodName(final String methodName) {
		this.methodName = methodName;
	}

	public void setPackageName(final String packageName) {
		this.packageName = packageName;
	}

	public void setVariableName(final String variableName) {
		this.variableName = variableName;
	}

	public String toCSVLine() {
		final List<String> elements = Arrays
			.asList(
				this.antiPatternName,
				this.variableName,
				this.methodName,
				this.className,
				this.packageName,
				this.filePath);
		return String.join(",", elements);
	}

	@Override
	public String toString() {
		final StringBuilder sb = new StringBuilder();
		sb.append("{ Anti-Pattern \"");
		sb.append(this.antiPatternName);
		sb.append("\"");
		if (!this.variableName.isEmpty()) {
			sb.append("\n\tVariable: ");
			sb.append(this.variableName);
		}
		if (!this.methodName.isEmpty()) {
			sb.append("\n\tMethod: ");
			sb.append(this.methodName);
		}
		if (!this.className.isEmpty()) {
			sb.append("\n\tClass: ");
			sb.append(this.className);
		}
		if (!this.packageName.isEmpty()) {
			sb.append("\n\tPackage: ");
			sb.append(this.packageName);
		}
		if (!this.filePath.isEmpty()) {
			sb.append("\n\tFile path: ");
			sb.append(this.filePath);
		}
		final String fileName = this.getFileName();
		if (!fileName.isEmpty()) {
			sb.append("\n\tFile name: ");
			sb.append(fileName);
		}
		sb.append("\n}");
		return sb.toString();
	}
}

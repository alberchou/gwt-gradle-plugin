/**
 * This file is part of gwt-gradle-plugin.
 *
 * gwt-gradle-plugin is free software: you can redistribute it and/or modify it under the terms of the GNU Lesser
 * General Public License as published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * gwt-gradle-plugin is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY; without even the
 * implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser
 * General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with gwt-gradle-plugin. If not,
 * see <http://www.gnu.org/licenses/>.
 */
package de.esoco.gwt.gradle.extension;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.gradle.api.Action;
import org.gradle.api.model.ObjectFactory;

import javax.inject.Inject;

public class GwtExtension {
	
	public static final String NAME = "gwt";
	public static final String DIRECTORY = "gwt";

	private String gwtVersion = "2.8.2";
	private boolean gwtServletLib = false;
	private boolean gwtElementalLib = false;
	private boolean gwtPluginEclipse = true;
	private String jettyVersion = "9.2.14.v20151106";
	/**
	 * Specifies Java source level.
	 */
	private String sourceLevel;

	/**
	 * GWT Module to compile.
	 */
	private final List<String> module = new ArrayList<>();

	private CompilerOption compile;
	private DevOption dev;
	private JettyOption jetty;

	@Inject
	public GwtExtension(ObjectFactory objects) {
		this.compile = objects.newInstance(CompilerOption.class);
		this.dev = objects.newInstance(DevOption.class);
		this.jetty = objects.newInstance(JettyOption.class);
	}

	public String getGwtVersion() {
		return gwtVersion;
	}

	public void setGwtVersion(String gwtVersion) {
		this.gwtVersion = gwtVersion;
	}

	public String getJettyVersion() {
		return jettyVersion;
	}

	public void setJettyVersion(String jettyVersion) {
		this.jettyVersion = jettyVersion;
	}

	public boolean isGwtServletLib() {
		return gwtServletLib;
	}

	public void setGwtServletLib(boolean gwtServletLib) {
		this.gwtServletLib = gwtServletLib;
	}

	public boolean isGwtElementalLib() {
		return gwtElementalLib;
	}

	public void setGwtElementalLib(boolean gwtElementalLib) {
		this.gwtElementalLib = gwtElementalLib;
	}

	public boolean isGwtPluginEclipse() {
		return gwtPluginEclipse;
	}

	public void setGwtPluginEclipse(boolean gwtPluginEclipse) {
		this.gwtPluginEclipse = gwtPluginEclipse;
	}

	public DevOption getDev() {
		return dev;
	}

	public void dev(Action<? super DevOption> action) {
		action.execute(dev);
	}

	public CompilerOption getCompile() {
		return compile;
	}

	public void compile(Action<? super CompilerOption> action) {
		action.execute(compile);
	}

	public JettyOption getJetty() {
		return jetty;
	}

	public void jetty(Action<? super JettyOption> action) {
		action.execute(jetty);
	}

	public String getSourceLevel() {
		return sourceLevel;
	}

	public void setSourceLevel(String sourceLevel) {
		this.sourceLevel = sourceLevel;
	}

	public List<String> getModule() {
		return module;
	}

	public void module(String... modules) {
		this.module.addAll(Arrays.asList(modules));
	}
}

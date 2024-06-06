package com.ashera.converter;

import java.util.List;

import com.ashera.core.IActivity;
import com.ashera.core.IFragment;
import com.ashera.css.StyleSheet;
import com.ashera.model.Error;
import com.ashera.model.Errors;
import com.ashera.widget.IWidget;
import com.ashera.widget.bus.EventBus;

public class DummyFragment implements com.ashera.core.IFragment {

	@Override
	public void onAttach(IActivity activity) {
		
	}

	@Override
	public void onDetach() {
		
	}

	@Override
	public void onCreate() {
		
	}

	@Override
	public void onDestroy() {
	}

	@Override
	public void onResume() {
		
	}

	@Override
	public void onPause() {
		
	}

	@Override
	public Object onCreateView(boolean measure) {
		return null;
	}

	@Override
	public EventBus getEventBus() {
		return null;
	}

	@Override
	public IWidget getRootWidget() {
		return null;
	}

	@Override
	public boolean hasDevData(String key) {
		return false;
	}

	@Override
	public Object getDevData(String key) {
		return null;
	}

	@Override
	public IActivity getRootActivity() {
		return null;
	}

	@Override
	public Object getArgumentsBundle() {
		return null;
	}

	@Override
	public void setRootWidget(IWidget widget) {
		
	}

	@Override
	public void storeUserData(String varName, Object objValue) {
	}

	@Override
	public Object getUserData(String varName) {
		return null;
	}

	@Override
	public void storeInTempCache(String varName, Object objValue) {
		
	}

	@Override
	public Object getFromTempCache(String varName) {
		return null;
	}

	@Override
	public StyleSheet getStyleSheet() {
		return null;
	}

	@Override
	public void setStyleSheet(StyleSheet styleSheet) {
		
	}

	@Override
	public boolean isViewLoaded() {
		return false;
	}

	@Override
	public void setFrame(int x, int y, int width, int height) {
		
	}

	@Override
	public void remeasure() {
		
	}

	@Override
	public List<Object> getDisposables() {
		return null;
	}

	@Override
	public void addDisposable(Object disposable) {
		
	}

	@Override
	public void addListener(IWidget widget, Object listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public <T> List<T> getListener(Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> List<T> getListener(IWidget widget, Class<T> type) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeListener(IWidget widget, Object listener) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Object getParentForRootWidget() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getFragmentId() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getActionUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void disableRemeasure() {
		
	}

	@Override
	public void enableRemeasure() {
		
	}

	@Override
	public void addError(Error error) {
	}

	@Override
	public boolean hasErrors() {
		return false;
	}

	@Override
	public void onCloseDialog() {
		
	}

	@Override
	public void resizeWindow(int width, int height) {
		
	}

	@Override
	public String getInlineResource(String key) {
		return null;
	}

	@Override
	public void setInlineResource(String key, String value, boolean append) {
		
	}

	@Override
	public IFragment getParent() {
		return null;
	}

	@Override
	public String getUId() {
		return null;
	}
}

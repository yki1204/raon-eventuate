package com.raon.eventuate.framework.message;

import java.util.Map;

import com.raon.core.framework.scope.RequestScopeUtil;
import com.raon.core.framework.scope.ScopeAttribute;

import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.messaging.common.MessageInterceptor;

public class RaonMessageInterceptor implements MessageInterceptor {
	
	final String SCOPE_ATTRIBUTE = "Scope-Attribute";
	
	@Override
	public void preSend(Message message) {
		Map<String, String> header = message.getHeaders();
		
		// message header에 RequestScopeAttribute를 json 형태로 추가함
		header.put(SCOPE_ATTRIBUTE, ((ScopeAttribute)RequestScopeUtil.getAttribute()).toJson());
	}

}

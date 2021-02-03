#Servlet API参数解析原理
    Servlet API 包括
    eg: HttpServletRequest        
        //Servlet API的参数处理器
        ServletRequestMethodArgumentResolver.
        @Override
        	public boolean supportsParameter(MethodParameter parameter) {
        		Class<?> paramType = parameter.getParameterType();
        		return (WebRequest.class.isAssignableFrom(paramType) ||
        				ServletRequest.class.isAssignableFrom(paramType) ||
        				MultipartRequest.class.isAssignableFrom(paramType) ||
        				HttpSession.class.isAssignableFrom(paramType) ||
        				(pushBuilder != null && pushBuilder.isAssignableFrom(paramType)) ||
        				Principal.class.isAssignableFrom(paramType) ||
        				InputStream.class.isAssignableFrom(paramType) ||
        				Reader.class.isAssignableFrom(paramType) ||
        				HttpMethod.class == paramType ||
        				Locale.class == paramType ||
        				TimeZone.class == paramType ||
        				ZoneId.class == paramType);
        	}
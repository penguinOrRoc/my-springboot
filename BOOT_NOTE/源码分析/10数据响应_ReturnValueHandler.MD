#ReturnValueHandler
    数据响应分为响应页面和响应数据
#响应数据 —— JSON、XML、XLS、图片/音视频、自定义协议数据
    jackson.jar + @ResponseBody   //spring-boot-starter-parent默认引入 jackson依赖
#响应页面


   #返回值解析器returnValueHandlers
        json类型数据的视图解析器：RequestResponseBodyMethodProcessor
        页面类型的视图解析器：ModelAndViewMethodReturnValueHandler
        
#自动返回JSON数据的原理
    DispatcherServlet.class
		ModelAndView mv = ha.handle(processedRequest, response, mappedHandler.getHandler());
    >AbstractHandlerMethodAdapter.class
    	ServletInvocableHandlerMethod invocableMethod = createInvocableHandlerMethod(handlerMethod);
        invocableMethod.invokeAndHandle(webRequest, mavContainer);
    >ServletInvocableHandlerMethod.class
   #利用反射执行目标方法，并获取返回值
        Object returnValue = invokeForRequest(webRequest, mavContainer, providedArgs);
        this.returnValueHandlers.handleReturnValue(
        					returnValue, getReturnValueType(returnValue), mavContainer, webRequest);
    >HandlerMethodReturnValueHandlerComposite.class
   #遍历获取返回值处理器    RequestResponseBodyMethodProcessor 支持对标注@ResponseBody注解的
        HandlerMethodReturnValueHandler handler = selectHandler(returnValue, returnType);
         ------------->
        	private HandlerMethodReturnValueHandler selectHandler(@Nullable Object value, MethodParameter returnType) {
        		boolean isAsyncValue = isAsyncReturnValue(value, returnType);
        		for (HandlerMethodReturnValueHandler handler : this.returnValueHandlers) {
        			if (isAsyncValue && !(handler instanceof AsyncHandlerMethodReturnValueHandler)) {
        				continue;
        			}
        			if (handler.supportsReturnType(returnType)) {
        				return handler;
        			}
        		}
        		return null;
        	}
   #处理返回值
        handler.handleReturnValue(returnValue, returnType, mavContainer, webRequest);
    >RequestResponseBodyMethodProcessor.class    
        	@Override
        	public void handleReturnValue(@Nullable Object returnValue, MethodParameter returnType,
        			ModelAndViewContainer mavContainer, NativeWebRequest webRequest)
        			throws IOException, HttpMediaTypeNotAcceptableException, HttpMessageNotWritableException {
        
        		mavContainer.setRequestHandled(true);
        		ServletServerHttpRequest inputMessage = createInputMessage(webRequest);
        		ServletServerHttpResponse outputMessage = createOutputMessage(webRequest);
        
        		// Try even with null return value. ResponseBodyAdvice could get involved.
   #使用消息转换器进行写出操作
        		writeWithMessageConverters(returnValue, returnType, inputMessage, outputMessage);
        	}
   #HTTPMessageConverter
    >AbstractMessageConverterMethodProcessor.class
            protected <T> void writeWithMessageConverters(……)｛
                ……
            ｝






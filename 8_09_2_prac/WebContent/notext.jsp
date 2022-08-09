<%
	int result = 1+1;
	application.setAttribute("result", result);	// 이건 계속 열려있는 값
	
	// 이건 1회용 요청객체
	request.setAttribute("result", result);
	
	// 여기서 응답이 처리되기때문에 위에서 리퀘스트한것이 사라져버림 ㅠㅠ
	// response.sendRedirect("./viewPage.jsp");
	
	// 이걸 어케해야할까?
	// foward 이용
	request.getRequestDispatcher("/WEB-INF/viewPage.jsp").forward(request, response);
	// 근데 이거 사용하면 주소창이 viewPage가 아니라 notext로 나옴.
	// 페이지 로직 흐름이 하나로 합쳐져서 그렇다.
	// viewPage를 사용자가 모르게 하려면, viewPage로 바로접근이 안되게 하려면:: 
	// web-INF를 이용.
	
%>
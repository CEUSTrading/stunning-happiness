	<header>
		<c:set var="nombre" value="${sessionScope.nombre}" />
		<div class="nav">
			<div id=nav-iz>
				<img alt="logo" src="../images/protologo2white.png" class="logo" />
			</div>
		</div>
		<ul id=menu-header>
			<li><a href="../index.jsp">Inicio</a></li>
			<li><a href="../view/mapa.jsp">Mapa</a></li>
			<li><a href="../view/converter.jsp">Consulta de precios</a></li>
			<c:if test="${empty email}">
				<li><a href="../view/Login.jsp">Consulta de direcciones</a></li>
			</c:if>
			<c:if test="${not empty email}">
				<li><a href="../view/Address.jsp">Consulta de direcciones</a></li>
			</c:if>

			<c:if test="${empty nombre}">
				<div class="dropdown">
					<button class="dropbtn">Login</button>
					<div class="dropdown-content">
						<a href="../view/Login.jsp">Entrar</a>
						<!-- <a href="#">Registro con CEUS</a> -->
						<!-- <a href="../googleAuth">Registro con Google</a> -->
						<a href="../view/Logup.jsp">Registrate</a>
					</div>
				</div>
			</c:if>
			<c:if test="${not empty nombre}">
				<!-- <li><a href="../closeSession">ˇBienvenido, <c:out value="${sessionScope.Infos[0]}"></c:out>!</a></li>  -->
				<li>ˇBienvenid@, <c:out value="${sessionScope.nombre}"></c:out>!</li>
				<li><a href="../closeSession">Cerrar sesión</a></li>
			</c:if>
		</ul>
	</header>
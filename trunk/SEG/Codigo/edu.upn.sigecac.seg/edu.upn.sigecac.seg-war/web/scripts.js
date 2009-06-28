function esconder_menu(){
	var s = document.getElementById('divspliter');
	s.setAttribute("class", "cuadro_interior_1col"); 
	s.setAttribute("className", "cuadro_interior_1col"); 
	return; 
}
function mostrar_menu(){
	var s = document.getElementById('divspliter');
	s.setAttribute("class", "cuadro_interior_2cols");
	s.setAttribute("className", "cuadro_interior_2cols");
	return;
}
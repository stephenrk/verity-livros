<%@ attribute name="id" required="true" %>

<input id="${id}" name="${id}" type="text" class="form-control" value="<fmt:formatDate value='${livro.dataPublicacao.time}' pattern='dd/MM/yyyy' />">

<script>
	$("#${id}").datepicker({
		dateFormat: "dd/mm/yy",
        changeYear: true,
        changeMonth: true,
        yearRange: "1940:*",
        dayNamesMin: ["Dom", "Seg", "Ter", "Qua", "Qui", "Sex", "Sab"],
        monthNamesShort: ["Jan", "Fev", "Mar", "Abr", "Mai", "Jun", "Jul", "Ago", "Set", "Out", "Nov", "Dez"]
	});
	$("#${id}").mask("99/99/9999");
</script>
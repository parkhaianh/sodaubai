<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<c:if test="${error != null}">
<div id="errorModal" class="" style="z-index:1000;">
    <div class="modal-dialog">
        <!-- Modal content-->
        <div class="modal-content">
            <div class="modal-body">
                <button type="button" class="close" id="close-modal" onclick="x()">&times;</button>
                <p>${error}</p>
            </div>
        </div>

    </div>
</div>
</c:if>
<script>
    function x() {
        $("#errorModal").hide();
    }
</script>
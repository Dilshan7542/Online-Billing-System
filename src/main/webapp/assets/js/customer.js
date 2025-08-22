const onDeleteCustomer=(customer)=> {
    console.log(customer);
    modalCallBackFn = () => {
        modalCallBackFn = () => null;
    }
}
const onEditCustomer=(userId)=> {
    modalCallBackFn = () => {
        alert(userId);
        modalCallBackFn = () => null;
    }
}

const saveCustomer=()=>{
    $('#customerForm').on('submit', function(e) {
        e.preventDefault(); // Prevent default form submission

        const formData = new FormData(this);
        const jsonData = {};
        formData.forEach((value, key) => {
            jsonData[key] = value;
        });
        const data = JSON.stringify(jsonData);
        console.log(data);

        $.ajax({
            url: '${pageContext.servletContext.contextPath}/api/v1/auth/login',
            type: 'POST',
            contentType: 'application/json',
            data:data,
            success: function(response) {
                console.log('Login successful:');
                console.log(response);
                window.location.href='${pageContext.servletContext.contextPath}/api/v1/dashboard';
            },
            error: function(err) {
                console.error('Login failed:', err);
                $('#invalidCredential').removeClass("d-none");
            }
        });
    });
}
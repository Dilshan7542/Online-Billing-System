<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<main class="w-100 h-100 d-flex justify-content-center">
    <section class="d-flex flex-column p-2">
        <section>
            <form id="customerForm" >
                <section class="row rounded-4 border p-2 pb-5">
                    <div class="col-6 p-1">
                        <label for="accountNo" class="form-label">Account No</label>
                        <input type="text" class="form-control" id="accountNo"
                               placeholder="Account No">
                    </div>
                    <div class="col-6 p-1">
                        <label for="customerName" class="form-label">Name</label>
                        <input type="text" class="form-control" id="customerName"
                               placeholder="Name">
                    </div>
                    <div class="col-6 p-1">
                        <label for="address" class="form-label">Address</label>
                        <input type="text" class="form-control" id="address"
                               placeholder="Address">
                    </div>
                    <div class="col-6 p-1">
                        <label for="phone" class="form-label">Phone</label>
                        <input type="text" class="form-control" id="phone"
                               placeholder="Phone">
                    </div>
                    <div class="col-6 p-1">
                        <label for="unitsConsumed" class="form-label">Phone</label>
                        <input type="text" class="form-control" id="unitsConsumed"
                               placeholder="Units Consumed">
                    </div>
                    <div class="col-12 p-1">
                        <div>
                            <button class="btn btn-sm btn-primary">Save</button>
                        </div>
                    </div>
                </section>
            </form>

        </section>
        <section>

            <section>
                <table class="table">
                    <thead>
                    <tr>
                        <th scope="col">#Id</th>
                        <th scope="col">Account No</th>
                        <th scope="col">Name</th>
                        <th scope="col">Address</th>
                        <th scope="col">Phone</th>
                        <th scope="col">Units Consumed</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="customer" items="${customerList}" varStatus="loop">
                        <tr>
                            <!-- index (1-based) -->
                            <th scope="row">${loop.index + 1}</th>
                            <td>${customer.accountNo}</td>
                            <td>${customer.name}</td>
                            <td>${customer.address}</td>
                            <td>${customer.phone}</td>
                            <td>${customer.unitsConsumed}</td>

                            <td>
                                <div class="d-flex gap-1">
                                    <!-- pass values to JS functions (note: wrap strings in quotes) -->
                                    <button class="btn btn-sm btn-danger"
                                            data-bs-toggle="modal" data-bs-target="#deleteModal"
                                            onclick="onDeleteCustomer('${customer.accountNo}')">
                                        delete
                                    </button>

                                    <!-- open edit modal and pass accountNo (you can fetch full record via AJAX or include other data-* attributes) -->
                                    <button class="btn btn-sm btn-primary"
                                            data-bs-toggle="modal" data-bs-target="#editModal"
                                            onclick="onEditCustomer('${customer.accountNo}')">
                                        edit
                                    </button>
                                </div>
                            </td>
                        </tr>
                    </c:forEach>

                    <!-- show message when list is empty -->
                    <c:if test="${empty customerList}">
                        <tr>
                            <td colspan="7" class="text-center">No customers found.</td>
                        </tr>
                    </c:if>
                    </tbody>
                </table>
            </section>
        </section>
    </section>
    <main>
        <!--Delete Modal -->
        <aside>
            <div class="modal fade" id="deleteModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Are Sure ?</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <p>Do you want to delete bill ?</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-danger" onclick="modalCallBackFn()">Yes</button>
                        </div>
                    </div>
                </div>
            </div>
        </aside>
        <!--Edit Modal -->
        <aside>
            <div class="modal fade" id="editModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1"
                 aria-labelledby="staticBackdropLabel" aria-hidden="true">
                <div class="modal-dialog modal-dialog-centered">
                    <div class="modal-content">
                        <div class="modal-header">
                            <h1 class="modal-title fs-5" id="staticBackdropLabel">Are Sure ?</h1>
                            <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                        </div>
                        <div class="modal-body">
                            <p>Do you want to Edit bill ?</p>
                        </div>
                        <div class="modal-footer">
                            <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
                            <button type="button" class="btn btn-danger" onclick="modalCallBackFn()">Yes</button>
                        </div>
                    </div>
                </div>
            </div>
        </aside>
    </main>
</main>


<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<main class="w-100 h-100 d-flex justify-content-center">
    <section class="d-flex flex-column p-2">
        <section>
            <form action="">
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
                        <th scope="col">itemId</th>
                        <th scope="col">itemName</th>
                        <th scope="col">pricePerUnit</th>
                        <th scope="col">Action</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <th scope="row">1</th>
                        <td>25552888</td>
                        <td>Dilshan</td>
                        <td>Gampaha</td>
                        <td>0762778752</td>
                        <td>5</td>
                        <td>
                            <div class="d-flex gap-1">
                                <button class="btn btn-sm btn-danger">delete</button>
                                <button class="btn btn-sm btn-primary">edit</button>
                            </div>
                        </td>
                    </tr>
                    </tbody>
                </table>
            </section>
        </section>
    </section>

</main>

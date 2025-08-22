<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<main class="w-100 h-100 d-flex justify-content-center">
    <section class="d-flex flex-column p-2">
        <section>
            <form action="">
                <section class="row rounded-4 border p-2 pb-5">
                    <div class="col-6 p-1">
                        <label for="username" class="form-label">Username</label>
                        <input type="text" class="form-control" id="username"
                               placeholder="Username">
                    </div>
                    <div class="col-6 p-1">
                        <label for="password" class="form-label">Password</label>
                        <input type="text" class="form-control" id="password"
                               placeholder="Password">
                    </div>
                    <div class="col-6 p-1">
                        <label for="role" class="form-label">Role</label>
                        <input type="text" class="form-control" id="role"
                               placeholder="Role">
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
                        <th scope="col">username</th>
                        <th scope="col">password</th>
                        <th scope="col">deviceId</th>
                        <th scope="col">role</th>
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
                                <button class="btn btn-sm btn-danger" data-bs-toggle="modal"
                                        data-bs-target="#deleteModal" onclick="onDeleteUser('Dilshan')">delete
                                </button>
                                <button class="btn btn-sm btn-primary" data-bs-toggle="modal"
                                        data-bs-target="#editModal">edit
                                </button>
                            </div>
                        </td>
                    </tr>
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

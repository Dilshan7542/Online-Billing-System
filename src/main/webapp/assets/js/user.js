const onDeleteUser=(userId)=> {
    modalCallBackFn = () => {
        alert(userId);
        modalCallBackFn = () => null;
    }
}
const onEditUser=(userId)=> {
    modalCallBackFn = () => {
        alert(userId);
        modalCallBackFn = () => null;
    }
}


import React from 'react';
import { Dialog, DialogTitle, DialogContent, DialogActions, Button, Box } from '@mui/material';

// 通用模態視窗組件
const TableModal = ({ openModal, handleOpenModal, modalContent, CloseModal }) => {
    return (
        <Dialog open={openModal} onClose={handleOpenModal}>
            <DialogTitle>詳細內容</DialogTitle>
            <DialogContent>
                <Box>{modalContent}</Box>
            </DialogContent>
            <DialogActions>
                <Button onClick={CloseModal} color="primary">
                    關閉
                </Button>
            </DialogActions>
        </Dialog>
    );
};

export default TableModal;
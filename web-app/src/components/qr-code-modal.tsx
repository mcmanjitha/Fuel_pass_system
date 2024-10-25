import React, { useRef } from "react";
import { Modal, Button } from "react-bootstrap";
import { QRCodeCanvas } from "qrcode.react";

interface QRCodeModalProps {
  link: string;
  show: boolean;
  handleClose: () => void;
}

const QRCodeModal: React.FC<QRCodeModalProps> = ({ link, show, handleClose }) => {
  const qrRef = useRef<HTMLDivElement | null>(null);

  const downloadQRCode = () => {
    const canvas = qrRef.current?.querySelector("canvas");
    if (canvas) {
      const url = canvas.toDataURL("image/png");
      const a = document.createElement("a");
      a.href = url;
      a.download = "qrcode.png";
      a.click();
    }
  };

  return (
    <Modal show={show} onHide={handleClose}>
      <Modal.Header closeButton>
        <Modal.Title>QR Code</Modal.Title>
      </Modal.Header>
      <Modal.Body>
        <div className="d-flex justify-content-center">
          <div ref={qrRef}>
            <QRCodeCanvas value={link} size={256} />
          </div>
        </div>
      </Modal.Body>
      <Modal.Footer>
        <Button variant="secondary" onClick={handleClose}>
          Close
        </Button>
        <Button variant="primary" onClick={downloadQRCode}>
          Download QR Code
        </Button>
      </Modal.Footer>
    </Modal>
  );
};

export default QRCodeModal;

export class EmployeeDTO {

    constructor(
        private _employeeName: string,
        private _photo: string,
        private _productivity: number,
        private _clumsiness: number,
        private _company: number,
        private _player: number
    ) { }

    public get player(): number {
        return this._player;
    }
    public set player(value: number) {
        this._player = value;
    }
    public get company(): number {
        return this._company;
    }
    public set company(value: number) {
        this._company = value;
    }
    public get clumsiness(): number {
        return this._clumsiness;
    }
    public set clumsiness(value: number) {
        this._clumsiness = value;
    }
    public get productivity(): number {
        return this._productivity;
    }
    public set productivity(value: number) {
        this._productivity = value;
    }
    public get photo(): string {
        return this._photo;
    }
    public set photo(value: string) {
        this._photo = value;
    }
    public get employeeName(): string {
        return this._employeeName;
    }
    public set employeeName(value: string) {
        this._employeeName = value;
    }

}
